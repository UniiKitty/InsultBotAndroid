package simez.com.insultbot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.speech.tts.TextToSpeech
import kotlinx.android.synthetic.main.activity_insult.*
import org.w3c.dom.Text

class Insult : AppCompatActivity (), TextToSpeech.OnInitListener {
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

        next_button.setOnClickListener({
            createInsult()
        })
    }

    private fun createInsult() {
        insult_text.text = generator.generate()
        if (speak_switch.isChecked) {
            tts!!.speak(insult_text.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }

    override fun onInit(status: Int) {
        // Required function
    }

    override fun onDestroy() {
        tts!!.stop();
        tts!!.shutdown();
        super.onDestroy()
    }
}
