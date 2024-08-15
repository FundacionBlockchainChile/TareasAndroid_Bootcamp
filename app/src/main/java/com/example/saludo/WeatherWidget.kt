package com.example.saludo

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class WeatherWidget : AppWidgetProvider() {
    companion object {
        public const val ACTION_UPDATE = "com.example.saludo.ACTION_UPDATE_WEATHER"
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_UPDATE) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(ComponentName(context, WeatherWidget::class.java))
            onUpdate(context, appWidgetManager, appWidgetIds)
        }
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateWeatherWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateWeatherWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val views = RemoteViews(context.packageName, R.layout.weather_widget)
    // Actualizar la información del clima
    views.setTextViewText(R.id.weather_info, "Sunny, 25°C")
    // Configurar la acción del botón para actualizar el clima
    val intent = Intent(context, WeatherWidget::class.java).apply {
        action = WeatherWidget.ACTION_UPDATE
        putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
    }
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    views.setOnClickPendingIntent(R.id.update_weather_button, pendingIntent)
    // Tell the AppWidgetManager to perform an update on the current app widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}