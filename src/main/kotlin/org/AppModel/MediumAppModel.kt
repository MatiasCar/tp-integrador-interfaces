package org.AppModel

import org.ui.bootstrap.getMediumSystem


class MediumAppModel () {

    val mediumSystem = getMediumSystem()
    var autores = mediumSystem.authors
    var notas = mediumSystem.notes
}