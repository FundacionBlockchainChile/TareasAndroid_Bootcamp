package com.example.saludo

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class CalendarWidget : AppWidgetProvider() {
    companion object {
        public const val ACTION_UPDATE = "com.example.saludo.ACTION_UPDATE"
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_UPDATE) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(ComponentName(context, CalendarWidget::class.java))
            onUpdate(context, appWidgetManager, appWidgetIds)
        }
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateCalendarWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateCalendarWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val views = RemoteViews(context.packageName, R.layout.calendar_widget)
    // Actualizar la fecha
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val currentDate = sdf.format(Date())
    views.setTextViewText(R.id.calendar_date, currentDate)
    // Configurar la acción del botón para actualizar la fecha
    val intent = Intent(context, CalendarWidget::class.java).apply {
        action = CalendarWidget.ACTION_UPDATE
        putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
    }
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    views.setOnClickPendingIntent(R.id.update_button, pendingIntent)
    // Tell the AppWidgetManager to perform an update on the current app widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}