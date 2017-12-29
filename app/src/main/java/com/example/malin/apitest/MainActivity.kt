package com.example.malin.apitest


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.beust.klaxon.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import android.widget.Toast
import android.widget.AdapterView.OnItemClickListener




class MainActivity : AppCompatActivity() {

    lateinit var MyListAdapter:ListAdapter
    var items = ArrayList<String?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGet.setOnClickListener {
            var omdb: omdb_request = omdb_request(this)
            var lv_Title: String = TitleText.text.toString()
            var picture: myImage = myImage()
            var me: Context = this
            doAsync {
                var json_obj: JsonObject = omdb.byTitle(lv_Title)
                uiThread {
                    longToast("done")
                    outYear.setText(json_obj.string("Year"))
                    outTime.setText(json_obj.string("Runtime"))
                    outPlot.setText(json_obj.string("Plot"))
                    val s: String = json_obj.string(fieldName = "imdbRating")!!
                    ratingBar.rating = s.toFloat()
                    picture.ShowURLimage(json_obj.string("Poster"), ImageView1, me)
                }
            }

        }

        searchbutton.setOnClickListener {
            var omdb: omdb_request = omdb_request(this)
            var lv_Title: String = TitleText.text.toString()

            var me: Context = this
            doAsync {
                var json_arr: JsonArray<JsonObject> = omdb.bySearch(lv_Title)!!


                uiThread {
                    longToast("done")

                    for (x in json_arr) {
                        items.add(x.string("Title"))
                    }
                    MyListAdapter = ArrayAdapter<String>(me, android.R.layout.simple_list_item_1, items)
                    FoundsListView.adapter = MyListAdapter

                }


            }


        }

         FoundsListView.setOnItemClickListener(object : OnItemClickListener {
             override fun onItemClick(parent: AdapterView<*>, view: View,
                                      position: Int, id: Long) {
                 // TODO Auto-generated method stub
                    TitleText.setText(items[position])
//                 Toast.makeText(this@MainActivity, items[position], Toast.LENGTH_SHORT).show()
             }
         });
    }
}


