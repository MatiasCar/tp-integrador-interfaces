package org.example.controllers

import io.javalin.http.Context
import org.ui.MediumSystem

class ContentController(val mediumSystem: MediumSystem){

    fun getContent(ctx : Context){
        val content = mediumSystem.latestAddedNotes().map {
            NoteInfo(it.title, it.body, it.categories.toString(), it.author.name) }
        ctx.status(200)
        ctx.json(mapOf(
                "content" to content
        ))
    }
}
