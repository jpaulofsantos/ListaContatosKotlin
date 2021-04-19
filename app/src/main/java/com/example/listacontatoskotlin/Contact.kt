package com.example.listacontatoskotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//criando a classe modelo Contact
//Anotando parcelize (para trafegar dados entre telas) - add id 'kotlin-android-extensions' no build.grade module
@Parcelize
data class Contact (
    var name: String,
    var phone: String,
    var picture: String
) : Parcelable