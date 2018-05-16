package simez.com.insultbot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_insult.view.*
import org.w3c.dom.Text

class Insult : AppCompatActivity() {
    private var insultText: TextView? = null
    private var nextButton: Button? = null
    private var speakButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insult)
        insultText = findViewById(R.id.insult_text) as TextView
        nextButton = findViewById(R.id.next_button) as Button
        speakButton = findViewById(R.id.speak_button) as Button
        createInsult()
    }

    private fun createInsult() {
        insultText!!.text = "Olla!"
    }
}
