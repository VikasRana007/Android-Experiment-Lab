package me.vikas.experimentLab.scalable_design.repository_impl

import me.vikas.experimentLab.scalable_design.ScalableNewsScreen
import me.vikas.experimentLab.scalable_design.repository.NewsApiRepository

class ScalableNews {


    val screen1 = ScalableNewsScreen(LocalNewsSourceImpl())
    val screen2 = ScalableNewsScreen(RemoteNewsSourceImpl())

}