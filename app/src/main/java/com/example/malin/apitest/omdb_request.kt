package com.example.malin.apitest

import android.app.RemoteInput
import android.content.Context
import android.util.Log
import com.beust.klaxon.*
import com.example.malin.apitest.R.string.omdbMOCK
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.io.File
import java.net.URL

/**
 * Created by malin on 28.12.2017.
 */
class omdb_request {

    var mainUrl = "https://www.omdbapi.com/?apikey=6e15bf3b"
    var tmpFIle = "C:\\Users\\malin\\Downloads\\json_omdb\\android.json"
    var moContext:Context
    constructor(io:Context){
        moContext = io
    }

    fun bySearch(iv_Title: String): JsonArray<JsonObject>? {
        val lv_param = "&s="+iv_Title
        val lv_omdb_result = URL(mainUrl+lv_param).readText()
//        val lv_omdb_result = "{\"Search\":[{\"Title\":\"All My Crazy Friends 3... Live Fast, Die Fat\",\"Year\":\"2007\",\"imdbID\":\"tt1166124\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Life in the Fast Lane\",\"Year\":\"2001\",\"imdbID\":\"tt1217582\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Times at Naughty America University 6\",\"Year\":\"2008\",\"imdbID\":\"tt1228677\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast & Female\",\"Year\":\"2002\",\"imdbID\":\"tt1238740\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"2 Fast 2 Furry\",\"Year\":\"2007\",\"imdbID\":\"tt1090635\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Times at Naughty America University 4\",\"Year\":\"2007\",\"imdbID\":\"tt1116764\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Forward\",\"Year\":\"2007\",\"imdbID\":\"tt1124327\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Copy\",\"Year\":\"1985\",\"imdbID\":\"tt1068812\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Nation\",\"Year\":\"2007\",\"imdbID\":\"tt1043634\",\"Type\":\"movie\",\"Poster\":\"N/A\"},{\"Title\":\"Fast Flight: British Isles\",\"Year\":\"2006\",\"imdbID\":\"tt0960064\",\"Type\":\"movie\",\"Poster\":\"N/A\"}]}"
        val sB:StringBuilder = StringBuilder( lv_omdb_result )
        val parser:Parser = Parser()
        var JO = parser.parse(sB) as JsonObject
        return JO.array<JsonObject>("Search")
//return parse(mainUrl+lv_param) as JsonArray<JsonObject>
    }
    fun byTitle(iv_Title: String):JsonObject{
        val lv_param = "&t="+iv_Title
        val lv_omdb_result = URL(mainUrl+lv_param).readText()
//        val lv_omdb_result = "{\"Title\":\"Android\",\"Year\":\"1982\",\"Rated\":\"PG\",\"Released\":\"01 Oct 1982\",\"Runtime\":\"80 min\",\"Genre\":\"Sci-Fi\",\"Director\":\"Aaron Lipstadt\",\"Writer\":\"James Reigle, Don Keith Opper, Will Reigle (based on an original idea by)\",\"Actors\":\"Klaus Kinski, Don Keith Opper, Brie Howard, Norbert Weisser\",\"Plot\":\"Strange doctor secretly experiments with androids on his space station. His assistant is Max, a curious android who wants to see the world and meet a girl. Criminals Maggie and two other hide on their station and soon violence erupts.\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"3 nominations.\",\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNjY4OTZlNTQtNGI2MC00YmM4LTgxZTEtZGJmZThiZmVhOWM3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.9/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"83%\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"5.9\",\"imdbVotes\":\"2,035\",\"imdbID\":\"tt0083557\",\"Type\":\"movie\",\"DVD\":\"12 Oct 2004\",\"BoxOffice\":\"N/A\",\"Production\":\"Media Home Entertainment\",\"Website\":\"N/A\",\"Response\":\"True\"}"
        val sB:StringBuilder = StringBuilder( lv_omdb_result )
        val parser:Parser = Parser()
        return parser.parse(sB) as JsonObject

//        doAsync {
//            uiThread {
//        }


    }
    fun parse(name: String) : Any? {
        val cls = Parser::class.java
        return cls.getResourceAsStream(name)?.let {
            inputStream -> return Parser().parse(inputStream)
        }
    }
}