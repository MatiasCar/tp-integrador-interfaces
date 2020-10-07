package org.ventanas

import org.appModel.AuthorAppModel
import org.appModel.MediumAppModel
import org.appModel.NotaAppModel
import org.uqbar.arena.kotlin.extensions.bindTo
import org.uqbar.arena.kotlin.extensions.text
import org.uqbar.arena.kotlin.extensions.width
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

abstract class FormNoteWindows(owner: WindowOwner, notaAppModel: NotaAppModel, var system: MediumAppModel, var authorAppModel: AuthorAppModel) : SimpleWindow<NotaAppModel>(owner, notaAppModel) {


    override fun createFormPanel(p0: Panel?) {
        Label(p0) with {
            text = "Title"
            TextBox(p0) with {
                bindTo("title")
                width = 150
            }
        }

        Label(p0) with {
            text = "Body"
            TextBox(p0) with {
                bindTo("body")
                width = 150
            }
        }

        Label(p0) with {
            text = "Categories"
            TextBox(p0) with {
                bindTo("categories")
                width = 150
            }
        }

    }
}