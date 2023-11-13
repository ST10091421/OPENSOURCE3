import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import com.example.navigationdrawer.R

class QuickIdentificationGuideFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quick_identification_guide, container, false)

        // Load bird information here
        populateBirdInformation(view)

        return view
    }

    private fun populateBirdInformation(view: View) {
        // Create a linear layout to hold each bird's information
        val linearLayout: LinearLayout = view.findViewById(R.id.birdInfoLinearLayout)

        // Populate bird information for each bird
        populateBird(
            linearLayout,
            "Blue Jay",
            "Blue, White",
            "The Blue Jay is a bright blue and white bird commonly found in North America. It is known for its distinctive colors and loud calls."
        )

        populateBird(
            linearLayout,
            "Cardinal",
            "Red",
            "The Cardinal is a beautiful bird with striking red plumage. It is often seen in gardens and wooded areas, adding a splash of color to its surroundings."
        )

        populateBird(
            linearLayout,
            "Goldfinch",
            "Yellow, Black",
            "The Goldfinch is a small bird with bright yellow plumage and black wings. It is commonly found in meadows and gardens, especially during the summer."
        )

        populateBird(
            linearLayout,
            "Robin",
            "Reddish-Brown, Gray",
            "The Robin has a reddish-brown breast and grayish upperparts. It is a familiar sight in gardens and parks, particularly during the spring when it builds nests."
        )

        populateBird(
            linearLayout,
            "Sparrow",
            "Brown, Gray",
            "Sparrows are small birds with brown and gray plumage. They are often found in urban areas, nesting in trees and bushes."
        )
        populateBird(
            linearLayout,
            "Black-capped Chickadee",
            "Black, White",
            "The Black-capped Chickadee is a small bird with a black cap and white cheeks. It is known for its distinctive chick-a-dee-dee-dee call."
        )
        populateBird(
            linearLayout,
            "American Goldfinch",
            "Yellow, Black",
            "The American Goldfinch is a small yellow bird with black wings. It is often seen feeding on sunflower seeds in gardens."
        )
        populateBird(
            linearLayout,
            "Northern Mockingbird",
            "Gray, White",
            "The Northern Mockingbird is a gray bird with white patches. It is known for its ability to mimic the sounds of other birds and even mechanical noises."
        )

        populateBird(
            linearLayout,
            "Eastern Bluebird",
            "Blue, Orange",
            "The Eastern Bluebird is a small bird with bright blue plumage and an orange chest. It is often found in open woodlands and meadows."
        )

        populateBird(
            linearLayout,
            "Cedar Waxwing",
            "Brown, Yellow",
            "The Cedar Waxwing is a sleek bird with brown plumage and yellow tips on its tail feathers. It is known for its distinctive crest and sleek appearance."
        )
        populateBird(
            linearLayout,
            "Bald Eagle",
            "Brown, White",
            "The Bald Eagle is a large bird of prey with a white head and brown body. It is a symbol of strength and freedom in many cultures."
        )

        populateBird(
            linearLayout,
            "Peregrine Falcon",
            "Blue, White",
            "The Peregrine Falcon is a powerful bird with blue-gray plumage. It is known for its incredible speed and is one of the fastest animals on Earth."
        )

        populateBird(
            linearLayout,
            "Ruby-throated Hummingbird",
            "Green, Red",
            "The Ruby-throated Hummingbird is a tiny bird with green plumage and a vibrant red throat. It is the only hummingbird species that breeds in eastern North America."
        )
    }

    private fun populateBird(linearLayout: LinearLayout, name: String, colors: String, description: String) {
        // Create a TextView to hold bird information
        val birdInfoTextView = TextView(requireContext())

        // Populate bird name, colors, and description
        birdInfoTextView.text = "\"$name\",\n\"$colors\",\n\"$description\"\n"

        // Add the TextView to the linear layout
        linearLayout.addView(birdInfoTextView)
    }
}