package com.mihir.jumpingmindtask.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mihir.jumpingmindtask.model.*

class TypeConverter {
    @TypeConverter
    fun classToJsonAmount(source: Amount?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonAmount(source: String?):Amount{
        return Gson().fromJson(source, Amount::class.java)
    }

    @TypeConverter
    fun classToJsonBoil(source: BoilVolume?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonBoil(source: String?):BoilVolume{
        return Gson().fromJson(source, BoilVolume::class.java)
    }

    @TypeConverter
    fun classToJsonFer(source: Fermentation?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonFer(source: String?):Fermentation{
        return Gson().fromJson(source, Fermentation::class.java)
    }

    @TypeConverter
    fun classToJsonHop(source: Hop?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonHop(source: String?):Hop{
        return Gson().fromJson(source, Hop::class.java)
    }

    @TypeConverter
    fun classToJsonIngredients(source: Ingredients?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonIngredients(source: String?):Ingredients{
        return Gson().fromJson(source, Ingredients::class.java)
    }

    @TypeConverter
    fun classToJsonMalt(source: Malt?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonMalt(source: String?):Malt{
        return Gson().fromJson(source, Malt::class.java)
    }

    @TypeConverter
    fun classToJsonMashTemp(source: MashTemp?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonMashTemp(source: String?):MashTemp{
        return Gson().fromJson(source, MashTemp::class.java)
    }

    @TypeConverter
    fun classToJsonMashMethod(source: Method?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonMethod(source: String?):Method{
        return Gson().fromJson(source, Method::class.java)
    }

    @TypeConverter
    fun classToJsonMashTemp(source: Temp?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonTemp(source: String?):Temp{
        return Gson().fromJson(source, Temp::class.java)
    }

    @TypeConverter
    fun classToJsonMashVolume(source: Volume?):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun classFromJsonVolume(source: String?):Volume{
        return Gson().fromJson(source, Volume::class.java)
    }

    @TypeConverter
    fun listToJsonString(value: List<String>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}

