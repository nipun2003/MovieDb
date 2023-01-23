package com.nipunapps.moviedb.first_time_display.data.local.serializer

import androidx.datastore.core.Serializer
import com.google.gson.Gson
import com.nipunapps.moviedb.first_time_display.data.local.dto.FirstTimeDisplaySettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.OutputStream

object FirstTimeDisplaySerializer : Serializer<FirstTimeDisplaySettings> {

    override val defaultValue: FirstTimeDisplaySettings
        get() = FirstTimeDisplaySettings()

    override suspend fun readFrom(input: InputStream): FirstTimeDisplaySettings {
        return try {
            val gson = Gson()
            val stringOfInput = input.readBytes().decodeToString()
            gson.fromJson(
                stringOfInput,
                FirstTimeDisplaySettings::class.java
            )
        } catch (e: Exception) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: FirstTimeDisplaySettings, output: OutputStream) {
        val gson = Gson()
        val byteArrayOfInput = gson.toJson(t).encodeToByteArray()
        withContext(Dispatchers.IO) {
            output.write(byteArrayOfInput)
        }
    }
}