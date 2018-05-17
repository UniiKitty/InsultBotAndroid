package simez.com.insultbot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_insult.view.*
//import org.w3c.dom.Text

class Insult : AppCompatActivity() {
    private var insultText: TextView? = null
    private var nextButton: Button? = null
    private var speakButton: Button? = null
    private var generator: InsultGenerator = InsultGenerator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insult)
        insultText = findViewById<TextView>(R.id.insult_text)
        nextButton = findViewById<Button>(R.id.next_button)
        speakButton = findViewById<Button>(R.id.speak_button)

        nextButton!!.setOnClickListener({
            createInsult()
        })
        createInsult()
    }

    private fun createInsult() {
        insultText!!.text = generator.generate()
    }
}
