package me.vikas.experimentLab.scalable_design.design_with_scalability_issues

class NewsApiImpl{
    private val api = NewsApi()

    fun getLocalNews(): String {
        return api.fetchLocalNews()
    }

     fun getRemoteNews(): String {
        return api.fetchRemoteNews()
    }


}