package com.isabelledionisius.mymovieapp.movies.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.mymovieapp.R
import com.isabelledionisius.mymovieapp.movies.model.Movie

class MovieAdapter(private val clickListener: MovieListClickListener) : RecyclerView.Adapter<MovieListViewHolder>()  {
    /**
     * User clicks on one row
     */
    interface MovieListClickListener {
        fun movieListItemClicked(movie: Movie)
    }
    private val movies = arrayOf<Movie>(
        Movie(
            2,
            "05/08/02",
            "About a boy",
            "Twelve year old Marcus Brewer lives with his chronically depressed single" +
                    " mother, Fiona Brewer. Both Fiona and Marcus beat to their own respective" +
                    " drummers. Marcus will do whatever he can to make his depressed mother happy," +
                    " even if it causes himself grief. As such, he realizes that he is perceived as" +
                    " different than most kids, as even the self-professed weird kids don't want to" +
                    " hang out with him as he is the target of bullying. Part of the taunts against" +
                    " him are the fact that he sings and speaks to himself without even realizing" +
                    " that he is doing it. Meanwhile, thirty-eight year old Will Freeman is a " +
                    "slacker who has lived comfortably off the royalties of a song written by his" +
                    " deceased father, and as such has never had to work a day in his life. He is " +
                    "a solitary man who places himself as the first and only priority in life. He" +
                    " comes across the idea that dating single moms meets his selfish carnal needs." +
                    " It is in this capacity that Will meets Marcus, as one of Will's single mother " +
                    "conquests, Suzie, is friends with the Brewers. Trying to escape his life but " +
                    "wanting Will to date Fiona, Marcus infiltrates Will's life, much to Will's " +
                    "chagrin. Will slowly begins to realize that Marcus is more than just a" +
                    " nuisance, but rather someone who needs some guidance navigating through " +
                    "the trials of adolescence and the trials of dealing with a suicidal mother," +
                    " and perhaps he can be a small part of providing that direction. Conversely, " +
                    "Marcus may be able to show Will the path to becoming a real adult.",
            "Drama",
            R.drawable.about_a_boy
        ),
        (Movie(
            2,
            "02/24/20",
            "The invisible man",
            "Trapped in a violent, controlling relationship with wealthy optics engineer" +
                    " and businessman Adrian Griffin, Cecilia Kass one night drugs him with" +
                    " Diazepam and escapes their home with her sister Emily.\n" +
                    "\n" +
                    "She hides out with childhood friend Detective James Lanier and his teenage " +
                    "daughter Sydney. Adrian seemingly commits suicide and leaves Cecilia \$5 " +
                    "million in his will, handled by his lawyer brother Tom. Cecilia suspects another" +
                    " presence in the house after several strange events and calls for James but he " +
                    "assures her she is just traumatized. During a job interview, she faints after " +
                    "finding her portfolio's contents removed. The doctor says they found high " +
                    "levels of Diazepam in her system. She finds the same bottle she drugged Adrian " +
                    "with, which she dropped during her escape, in her bathroom.\n" +
                    "\n" +
                    "She arranges a meeting with Tom and James, insisting that Adrian faked his" +
                    " death and used his optics expertise to become invisible in order to torment" +
                    " her but gets rebuffed. Sydney is hit by an unseen force, leading her and" +
                    " James to assume Cecilia did it. Cecilia tries a number of tactics to catch " +
                    "the figure. After finding Adrian's old phone and covering the figure with paint," +
                    " she ends up in a violent struggle before escaping to Adrian's home to investigate." +
                    " In his lab, she finds a suit that confirms her suspicions. The invisible" +
                    " figure attacks again so she flees and contacts Emily. The pair meet in a" +
                    " restaurant but the invisible figure slits Emily's throat and places the" +
                    " knife in Cecilia's hand, framing her for the crime.\n" +
                    "\n" +
                    "Remanded to a mental hospital while she awaits trial, a staffer informs" +
                    " Cecilia that she is pregnant. Tom offers to get her charges dropped if she " +
                    "agrees to \"return to him\" and raise the child, implying that he helped his " +
                    "brother stage his suicide while revealing Adrian tampered with her birth " +
                    "control to ensure she became pregnant. Cecilia refuses and steals a pen from " +
                    "his briefcase. That night, she uses the pen to pretend to commit suicide to " +
                    "draw the invisible figure out. When the figure tries to stop her, she stabs " +
                    "him repeatedly, causing the suit to malfunction. The security team arrives but " +
                    "the figure incapacitates them before fleeing the hospital with Cecilia in " +
                    "pursuit. Promising not to harm her because of her pregnancy, the figure " +
                    "instead threatens to attack those she loves.\n" +
                    "\n" +
                    "Cecilia races to James' house, where she finds the figure attacking him and " +
                    "Sydney. She manages to shoot him but when she unmasks him, it is Tom in the" +
                    " suit. Police find a captive Adrian alive at his house, tied up and claiming " +
                    "Tom held him prisoner. Cecilia disputes this, insisting the brothers must " +
                    "have shared the suit, with Adrian sending Tom to the house knowing what would " +
                    "happen.\n" +
                    "\n" +
                    "In an attempt to get Adrian to confess, she meets him at his house while James" +
                    " listens on a wire. She agrees to mend their relationship but only if he " +
                    "confesses to being the figure. Adrian insists Tom did kidnap him, claiming " +
                    "the experience changed his outlook on life and how he treated her. When she " +
                    "cries, Adrian alludes to his abuse, using similar phrasing to that of the " +
                    "figure. Smiling, Cecilia departs to use the restroom. Moments later, the " +
                    "security camera captures Adrian seemingly committing suicide. Cecilia returns " +
                    "and apparently distraught, calls the police. Out of the camera's sight however," +
                    " she taunts Adrian after retrieving the spare suit she used to kill him.\n" +
                    "\n" +
                    "When James arrives, she confirms what the camera saw. He spots the suit in her" +
                    " bag but allows her to leave. Relieved that she's finally free of Adrian," +
                    " Cecilia leaves with the suit.",
            "Psycho",
            R.drawable.the_invisible_man
        )
                ),
        Movie(
            2,
            "06/20/20",
            "American Pastoral",
            "Seymour Irving Levov is born and raised in the Weequahic section of Newark," +
                    " New Jersey, in 1927 as the elder son of a successful Jewish American glove " +
                    "manufacturer, Lou Levov, and his wife Sylvia. Called \"the Swede\" because of" +
                    " his anomalous blond hair, blue eyes and Nordic good looks, Seymour is a star" +
                    " athlete in high school; a two-year veteran of the Marine Corps; and the" +
                    " narrator Nathan Zuckerman's idol and hero. Zuckerman and Seymour's younger" +
                    " brother, Jerry—who grows into a curmudgeonly, irascible heart surgeon with " +
                    "little empathy for the Swede—are schoolmates and close friends. The Swede " +
                    "eventually takes over his father's glove factory and marries Dawn Dwyer, a " +
                    "former beauty queen from nearby Elizabeth, whom he met in college.\n" +
                    "\n" +
                    "Seymour establishes what he believes to be a perfect American life with a" +
                    " beloved wife and daughter, a satisfying business career, and a magnificent " +
                    "house in the idyllic hamlet of Old Rimrock. Yet, as the Vietnam War and racial" +
                    " unrest wrack the country and destroy inner-city Newark, his precocious " +
                    "teenage daughter Meredith (\"Merry\"), beset by an emotionally debilitating" +
                    " stutter and outraged by the war, becomes increasingly radical in her beliefs." +
                    " In February 1968, Merry plants a bomb in the Old Rimrock post office, which " +
                    "kills a bystander; she goes into permanent hiding. Seymour finds Merry five" +
                    " years later, living in deplorable conditions in inner-city Newark. During " +
                    "this reunion, Merry reveals that she was responsible for several more bombings," +
                    " killing three more people. Although Merry informs him that her actions were" +
                    " deliberate, Seymour decides to keep their meeting a secret, believing Merry" +
                    " has been manipulated by an unknown political group and a mysterious woman " +
                    "named Rita Cohen.\n" +
                    "\n" +
                    "At a dinner party, Seymour discovers that his wife Dawn has been having an" +
                    " affair with Princeton-educated architect William Orcutt III, for whom she" +
                    " undergoes a facelift. Seymour then realizes that his wife is planning to " +
                    "leave him for Orcutt. It is revealed that Seymour himself previously had a" +
                    " short-term affair with Merry's speech therapist, Sheila Salzman, and that " +
                    "she and her husband Shelly hid Merry in their home after the post office" +
                    " bombing. Seymour sadly concludes that everyone he knows may have a veneer " +
                    "of respectability, but each engages in subversive behavior and that he cannot " +
                    "understand the truth about anyone based upon the conduct they outwardly " +
                    "display. He is forced to see the truth about the chaos and discord rumbling " +
                    "beneath the \"American pastoral\", which has brought about profound personal" +
                    " and societal changes he no longer can ignore. Simultaneously, the dinner " +
                    "party underscores the fact that no one ever truly understands the hearts " +
                    "of other people.",
            "Drama",
            R.drawable.american_pastoral
        ),
        Movie(
            2,
            "06/25/04",
            "The invisible",
            "At a modern-day nursing home, an elderly man, Duke, reads a romantic story " +
                    "from his notebook to a fellow patient.\n" +
                    "\n" +
                    "In 1940, Seabrook Island, South Carolina, poor lumbermill worker Noah Calhoun " +
                    "sees 17-year-old heiress Allison \"Allie\" Hamilton at a carnival, pursues her," +
                    " and they have a summer romance. After weeks of dating, Noah takes Allie to an " +
                    "abandoned house that he intends to buy for them. They try to have sex for the " +
                    "first time, but are interrupted by Noah's friend Fin with the news that Allie's " +
                    "parents have the police looking for her. Due to their difference in social class," +
                    " Allie's parents were never fond of Noah, and were betting against the" +
                    " relationship from the beginning.\n" +
                    "\n" +
                    "When Allie and Noah returned to her parents' mansion, Allie's mother Anne " +
                    "ruthlessly insulted Noah solely due to his social status and banned her " +
                    "from seeing him. Noah walks out and Allie chases after him; an argument" +
                    " ensues, leading Allie to break up with Noah in the heat of the moment. The " +
                    "next morning, Anne announces that the family is returning home to Charleston " +
                    "that same day. Allie attempts to contact Noah, but is unable to find him, so " +
                    "she asks Fin to tell Noah that she loves him. When Noah receives the message " +
                    "he rushes to Allie's home, only to find the house gated up and empty.\n" +
                    "\n" +
                    "Noah wrote a letter to Allie every day for a year, but it is later revealed " +
                    "that Allie's mother had been intercepting the letters so that they never reach" +
                    " Allie. After 365 letters, Noah gives up and stops writing. While apart, Noah" +
                    " enlists with Fin to fight in World War II, where Fin is killed in battle." +
                    " Allie volunteers as a nurse's aide in a hospital for wounded soldiers, where " +
                    "she meets captain Lon Hammond Jr., a young lawyer who comes from old Southern " +
                    "money. After a few years being together, the two become engaged, to the delight " +
                    "of Allie's parents.\n" +
                    "\n" +
                    "When Noah returns from the war, his father has sold their home so that Noah" +
                    " can buy the abandoned house. While visiting Charleston, Noah stumbles upon " +
                    "seeing Allie and chases after her only to witness Allie and Lon kissing at a " +
                    "restaurant; he convinces himself that if he refurbishes the house, Allie will" +
                    " come back to him. After not seeing or hearing from Noah in years, while Allie" +
                    " is being fitted for her wedding dress, she is startled and faints when she " +
                    "sees in the newspaper that Noah has completed the house to the specifications" +
                    " she made years before, and is trying to sell it.\n" +
                    "\n" +
                    "Allie is overwhelmed with memories and unresolved feelings for Noah, and asks" +
                    " permission from Lon to take a little trip before the wedding. She returns to" +
                    " Seabrook to find Noah living in their dream house. The two rekindle their " +
                    "relationship and eventually have sex. Several days later, Anne appears on " +
                    "Noah's doorstep to warn Allie that Lon has followed her to Seabrook. Anne " +
                    "reveals that, in her youth, she had been in love with a lower-class young man " +
                    "and was still thinking about him; Anne then gives Allie the letters that Noah " +
                    "wrote to her as an admission that she had hidden them from Allie. Subsequently," +
                    " Allie confesses to Lon that she had spent time with Noah, and eventually " +
                    "returns to her relationship with Noah.\n" +
                    "\n" +
                    "In the present narrative, it is revealed that the elderly woman is actually" +
                    " Allie now stricken with dementia and Duke is actually her husband Noah. Years" +
                    " ago during the early stages of her illness, he had been told by Allie to " +
                    "re-read their journals to help her recall her past. One day during the reading" +
                    " sessions, she briefly remembers Noah and wants them to run away together. He " +
                    "reminds her of her dementia and she asks how long they have before she forgets " +
                    "again, and Noah tells her that the last time it happened, it was about five" +
                    " minutes.\n" +
                    "\n" +
                    "She cries and they embrace, but Allie soon forgets who Noah is again and in " +
                    "her ensuing panic, medical personnel are forced to sedate her. Noah suffers a " +
                    "heart attack and is sent to the hospital, while Allie is sent to a dementia " +
                    "ward in the same hospital. Noah visits Allie's room at midnight, causing her " +
                    "to remember him again. He proceeds to remind her of her illness again, though " +
                    "he reassures her that they can do anything with the love they share. They " +
                    "kiss, hold hands, and fall asleep together, with Noah telling Allie," +
                    " \"I'll be seeing you\". In the morning, a nurse discovers that they have " +
                    "both died in their sleep, with their hands still clasped together.",
            "Romance",
            R.drawable.the_notebook
        )
    )


    /**
     * View holder is being bcreated
     * @ returns MovieListHOlder
     */
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context)// the method from takes the parents context
         // creating a view
            .inflate(R.layout.movie_list_holder,parent,false)
        // now that we have created the view we have to create the viewholder from it
        // the view holder takes in the view that we have just inflated
        return MovieListViewHolder(
            view
        )
    }
    /**
     * returns the movie objects
     */
    fun getList():Array<Movie> {
        return movies
    }

    /**
     * determines the size off the array
     */
    override fun getItemCount(): Int {
        return movies.size
    }
    // this method displays the content
   override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.titleTextView.text=movies[position].title
        holder.genreTextView.text = movies[position].genre
        holder.posterImageView.setImageResource(movies[position].poster)
        holder.itemView.setOnClickListener {
            clickListener.movieListItemClicked(movies[position])
        }

    }


}