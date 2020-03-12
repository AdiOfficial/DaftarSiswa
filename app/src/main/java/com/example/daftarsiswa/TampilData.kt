package com.example.daftarsiswa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarsiswa.tampildata.DataItem
import com.example.daftarsiswa.tampildata.Tampildata
import kotlinx.android.synthetic.main.activity_recycler_tampil.*
import retrofit2.Call
import retrofit2.Response

class TampilData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_tampil)

        //panggil disini
        Network.getService().daftarsiswa()
            .enqueue(object : retrofit2.Callback<Tampildata> {
                override fun onFailure(call: Call<Tampildata>, t: Throwable) {

                }

                override fun onResponse(call: Call<Tampildata>, response: Response<Tampildata>) {
                    val dataItem = response.body()?.data
                    val adapter = AdapterTampil(
                        dataItem,
                        this@TampilData,
                        object : AdapterTampil.OnClickListener {
                            override fun onClick(list: DataItem?, position: Int) {

                            }

                        })

                    recylersiswa.layoutManager = LinearLayoutManager(this@TampilData)
                    recylersiswa.adapter = adapter

                }

            })
    }
}
