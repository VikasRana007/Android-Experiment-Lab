package me.vikas.experimentLab.scalable_design.repository_impl

import me.vikas.experimentLab.scalable_design.repository.NewsApiRepository

class RemoteNewsSourceImpl : NewsApiRepository {
    override fun getRemoteNews(): String {
        return "Remote News"
    }
}