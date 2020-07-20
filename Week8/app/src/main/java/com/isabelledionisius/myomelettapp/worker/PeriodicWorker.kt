package com.isabelledionisius.myomelettapp.worker
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

class PeriodicWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context,workerParameters ) {

    // every worker has to override the doWork() function
    // that describes what kind of work will run
    // result can be a success or a failure
    override fun doWork():Result {
        // opening an http connection
        val imageUrl = URL("http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet")
        val connection = imageUrl.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()
        // creating a file to store the omelett data
        //adding a timestamp to the omelett image
        val imagePath = "omelett_title_${System.currentTimeMillis()}.jpg"
        val inputStream = connection.inputStream

        // storing the data in the external directory of this app => easy to find
        val file = File(applicationContext.externalMediaDirs.first(),imagePath)

        // defining output
        // writing one chunk at atime to the file
        // finally returning the result
        // we need the buffer to slowly read the file in a buffered way
        val outputStream = FileOutputStream(file)
        outputStream.use { output ->
            val buffer = ByteArray(4*1024)
            var byteCount = inputStream.read(buffer)

            while(byteCount > 0) {
                output.write(buffer,0,byteCount)
                byteCount = inputStream.read(buffer)
            }
            output.flush()
        }
        // then returning the omelett data path to the worker output
        //using the workDataOf function to build the output object for the worker
        val output = workDataOf("omelettData_path" to file.absolutePath)
        return Result.success(output)// returning the output through the result
    }
}





