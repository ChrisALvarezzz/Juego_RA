package mx.uacj.alumnos.juego_ra.modelos.servicios

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class ReproductorAudio(private val contexto: Context){
    private var reproductor_media: MediaPlayer? = null

    fun cargar_audio(id_audio: Int){
        if(reproductor_media == null){
            reproductor_media = MediaPlayer.create(contexto, id_audio)

            reproductor_media?.setOnCompletionListener {
                Log.v("AUDIO", "FINALIZO LA EJECUCION")
            }

            reproductor_media?.setOnPreparedListener {
                Log.v("AUDIO", "SE cargo el audio")
                reproductor_media?.start()

            }
        }
    }

    fun pausar(){
        reproductor_media?.pause()
    }

    fun detener(){
        reproductor_media?.stop()
        reproductor_media?.release()
        reproductor_media = null
    }
}