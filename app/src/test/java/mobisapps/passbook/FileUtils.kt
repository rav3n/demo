package mobisapps.passbook

import java.io.IOException

class FileUtils {
    fun readString(fileName: String): String? {
        val stream = javaClass.classLoader.getResourceAsStream(fileName)
        try {
            val size = stream!!.available()
            val buffer = ByteArray(size)
            stream!!.read(buffer)
            return kotlin.text.String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } finally {
            try {
                if (stream != null) {
                    stream!!.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
}
