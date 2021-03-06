package net.ntworld.mergeRequestIntegrationIde.diff

import com.intellij.openapi.Disposable
import com.intellij.openapi.vcs.changes.Change
import net.ntworld.mergeRequest.Commit
import net.ntworld.mergeRequest.MergeRequest
import net.ntworld.mergeRequest.ProviderData
import net.ntworld.mergeRequestIntegrationIde.Model
import java.util.*

interface DiffModel : Model<DiffModel.DataListener>, Disposable {
    val providerData: ProviderData

    val mergeRequest: MergeRequest

    val commits: List<Commit>

    val change: Change

    val commentsOnBeforeSide: List<CommentPoint>

    val commentsOnAfterSide: List<CommentPoint>

    var displayResolvedComments: Boolean

    fun rebuildComments(showResolved: Boolean)

    enum class Source {
        UI,
        NOTIFIER
    }

    interface DataListener : EventListener {
        fun onCommentsUpdated(source: Source)
    }
}
