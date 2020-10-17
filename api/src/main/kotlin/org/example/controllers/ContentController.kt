package org.example.controllers

import io.javalin.http.Context
import org.ui.MediumSystem
import org.ui.NotFound

class ContentController(val mediumSystem: MediumSystem){

    fun getContent(ctx : Context){
        val content = mediumSystem.latestAddedNotes().map {
            NoteInfo(it.id,it.title, it.body, it.categories.toString(), it.author.name, it.comments) }
        ctx.status(200)
        ctx.json(mapOf(
                "content" to content
        ))
    }

    fun getNoteById(ctx : Context){
        val idContent = ctx.pathParam(":contentId")
        try{
            val content = mediumSystem.getNote(idContent)
            ctx.status(200)
            ctx.json(
                    NoteInfo(content.id,
                            content.title,
                            content.body,
                            content.categories.toString(),
                            content.author.name,
                            content.comments)
            )
        }
        catch (e : NotFound){
           ctx.status(404)
            ctx.json(mapOf(
                    "result" to "error",
                    "message" to e.message
            ))
        }
    }
}
