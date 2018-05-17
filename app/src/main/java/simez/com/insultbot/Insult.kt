package simez.com.insultbot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.speech.tts.TextToSpeech
import org.w3c.dom.Text

class Insult : AppCompatActivity (), TextToSpeech.OnInitListener {
    private var insultText: TextView? = null
    private var nextButton: Button? = null
    private var speakButton: Button? = null
    private var tts: TextToSpeech? = null
    private var generator: InsultGenerator = InsultGenerator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTTS()
        setupView()
        createInsult()
    }

    private fun setupTTS() {
        tts = TextToSpeech(this, TextToSpeech.OnInitListener() {})
    }

    private fun setupView() {
        setContentView(R.layout.activity_insult)
        insultText = findViewById<TextView>(R.id.insult_text)
        nextButton = findViewById<Button>(R.id.next_button)
        speakButton = findViewById<Button>(R.id.speak_button)

        nextButton!!.setOnClickListener({
            createInsult()
        })

        speakButton!!.setOnClickListener({
            speakInsult()
        })
    }

    private fun createInsult() {
        insultText!!.text = generator.generate()
    }

    private fun speakInsult() {
        tts!!.speak(insultText!!.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {

    }

    override fun onDestroy() {
        tts!!.stop();
        tts!!.shutdown();
        super.onDestroy()
    }
}
