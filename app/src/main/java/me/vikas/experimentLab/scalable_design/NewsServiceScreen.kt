package me.vikas.experimentLab.scalable_design

import me.vikas.experimentLab.scalable_design.design_with_scalability_issues.NewsApiImpl

class NewsServiceScreen {
    private val newsApiImpl = NewsApiImpl()


    private fun newsRemoteData() {
        newsApiImpl.getRemoteNews()
    }

    private fun newsLocalData() {
        newsApiImpl.getLocalNews()
    }

}