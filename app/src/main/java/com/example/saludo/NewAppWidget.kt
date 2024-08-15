package com.example.saludo

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.content.ComponentName
import android.widget.RemoteViews

class NewAppWidget : AppWidgetProvider() {

    companion object {
        var clickCount: Int = 0
            private set

        public const val ACTION_CLICK = "com.example.saludo.ACTION_CLICK"

        fun incrementClickCount() {
            clickCount++
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_CLICK) {
            incrementClickCount()
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(ComponentName(context, NewAppWidget::class.java))
            onUpdate(context, appWidgetManager, appWidgetIds)
        }
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)

    // Actualizar el texto del contador usando la propiedad pública
    views.setTextViewText(R.id.appwidget_text, "Click Count: ${NewAppWidget.clickCount}")

    // Configurar la acción del botón para incrementar el contador
    val intent = Intent(context, NewAppWidget::class.java).apply {
        action = NewAppWidget.ACTION_CLICK
        putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
    }
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    views.setOnClickPendingIntent(R.id.appwidget_button, pendingIntent)

    // Tell the AppWidgetManager to perform an update on the current app widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}