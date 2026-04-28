package me.vikas.experimentLab.scalable_design

import me.vikas.experimentLab.scalable_design.repository.NewsApiRepository

/**
 * This is the Real Swap Implementation
 */

class ScalableNewsScreen(private val repo: NewsApiRepository) {

    private fun getLocalNews() {
        repo.getNews()
    }

    private fun getRemoteNews() {
        repo.getNews()
    }

}