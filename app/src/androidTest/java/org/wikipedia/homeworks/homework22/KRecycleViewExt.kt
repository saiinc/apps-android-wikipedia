package org.wikipedia.homeworks.homework22

import android.content.res.Resources.NotFoundException
import android.view.View
import androidx.media3.common.util.Log
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.name
import kotlin.math.min

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.invokeById(
    targetIndex: Int, //индекс нужного блока
    targetId: Int,
    blockName: String,
    limiter: Int, // ограничение по поиску блоков
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = -1
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.invokeByClass(
    targetIndex: Int, //индекс нужного блока
    targetClass: Class<out View>,
    blockName: String,
    limiter: Int, // ограничение по поиску блоков
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = -1
    val max = min(limiter, getSize())
    for (i in 0 until limiter) {
        scrollTo(i + 3)
        Log.d("KASPRESSO", "limiter = $limiter and size is ${getSize()}")
        childAt<T>(i) {
            if (hasClassAction(targetClass)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.findById(
    targetIndex: Int, //индекс нужного блока
    targetId: Int,
    limiter: Int, // ограничение по поиску блоков
    blockName: String,
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.getName().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}