package org.example.controllers

import io.javalin.http.BadRequestResponse
import io.javalin.http.Context
import org.example.MediumTokenJWT
import org.ui.DraftComment
import org.ui.MediumSystem
import org.ui.NotFound

class ContentController(val mediumToken: MediumTokenJWT,val mediumSystem: MediumSystem){

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


    fun addCommentToNoteById(ctx : Context){
        val token = ctx.header("Authorization")
        val userId = mediumToken.validate(token!!)
        val id = ctx.pathParam(":contentId")
        val comment = ctx.body<DraftComment>()
        try {
            mediumSystem.addComment(id, userId, comment)
            ctx.status(200)
            ctx.json(mapOf(
                    "result" to "ok"
            ))
        }
        catch (e : NotFound){
            ctx.status(404)
            ctx.json(mapOf(
                    "result" to "error",
                    "message" to e.message
            ))
        }
    }



    fun searchNoteByTitle(ctx : Context){
        val text = ctx.queryParam("text") ?: throw BadRequestResponse("Invalid query - param text is null")
        val search = mediumSystem.searchNotesByTitle(text)
                .map { NoteInfo(it.id,
                        it.title,
                        it.body,
                        it.categories.toString(),
                        it.author.name,
                        it.comments) }
        ctx.status(200)
        ctx.json(mapOf(
                "content" to search
        ))
    }


    fun searchNoteByCategory(ctx : Context){
        val category = ctx.pathParam("name")
        val search = mediumSystem.searchNotesByCategory(category).map { NoteInfo(it.id,
                        it.title,
                        it.body,
                        it.categories.toString(),
                        it.author.name,
                        it.comments) }
        ctx.status(200)
        ctx.json(mapOf(
                "categories" to search
        ))
    }
}
