package com.studynadezhdatarabina.android.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import kotlin.collections.List as KotlinCollectionsList

private const val POEM_LOG_TAG = "PoemLogTag"
private const val VALUE = "Value"


class MainActivity : AppCompatActivity() {

    private val poem: String = """
    Поспевает брусникa,
    Стали дни холоднее,
    И от птичьего крика
    В сердце только грустнее.
    Стаи птиц улетают
    Прочь, за синее море.
    Все деревья блистают
    В разноцветном уборе.
    Солнце реже смеется,
    Нет в цветах благовонья.
    Скоро Осень проснется
    И заплачет спросонья.
    """.trimIndent()

    private val string = stringToList(poem)
    private lateinit var answerTextView: TextView
    private lateinit var dialogButton: Button
    private lateinit var qetionEditText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(POEM_LOG_TAG, string[0])
        Log.d(POEM_LOG_TAG, string[1])

        val answerAboutWeatherString: String = getString(R.string.quotes)
        val answerAboutWeatherList = stringToList(answerAboutWeatherString)

        answerTextView = findViewById(R.id.answer_text_view)
        dialogButton = findViewById(R.id.dialog_button)
        qetionEditText = findViewById<TextView>(R.id.qetion_edit_text)

        qetionEditText.visibility = View.GONE
        if (savedInstanceState != null)
            answerTextView.text=savedInstanceState.getString(VALUE)
        else
            answerAboutWeather(0, answerAboutWeatherList)

        dialogButton.setOnClickListener {
            answerAboutWeather(
                Random.nextInt(answerAboutWeatherList.lastIndex),
                answerAboutWeatherList
            )
        }

    }

    private fun answerAboutWeather(integer: Int, answer: kotlin.collections.List<String>) {

        answerTextView.text = answer[integer]
    }

    override fun onStart() {
        super.onStart()
        Log.d(POEM_LOG_TAG, string[2])
        Log.d(POEM_LOG_TAG, string[3])
    }

    override fun onResume() {
        super.onResume()
        Log.d(POEM_LOG_TAG, string[4])
        Log.d(POEM_LOG_TAG, string[5])
    }

    override fun onPause() {
        super.onPause()
        Log.d(POEM_LOG_TAG, string[6])
        Log.d(POEM_LOG_TAG, string[7])

    }

    override fun onStop() {
        super.onStop()
        Log.d(POEM_LOG_TAG, string[8])
        Log.d(POEM_LOG_TAG, string[9])

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d(POEM_LOG_TAG, string[10])
        Log.d(POEM_LOG_TAG, string[11])
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALUE, answerTextView.text.toString())


    }


    // Presents a verse as a List with separate lines
    private fun stringToList(textIn: String): KotlinCollectionsList<String> {
        var ineger = 0
        val result = mutableListOf<String>()

        while (ineger <= textIn.lastIndex) {

            val litterToString = mutableListOf<Char>()

            while (textIn[ineger] != '\n' && ineger < textIn.lastIndex) {
                litterToString.add(textIn[ineger])
                ineger += 1
            }
            if (textIn[ineger] == '\n') {
                result.add(litterToString.joinToString(separator = ""))
                ineger += 1
            }

            if (ineger == textIn.lastIndex) {
                litterToString.add(textIn[ineger])
                result.add(litterToString.joinToString(separator = ""))
                ineger += 1
            }

        }

        return result
    }


}