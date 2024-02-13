package devv.abubakar.simple

import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager
import android.graphics.Color

class Abubakar private constructor() {

    companion object {
        // Singleton instance
        private var instance: Abubakar? = null

        // Get the instance or create a new one
        fun getInstance(): Abubakar {
            return instance ?: synchronized(this) {
                instance ?: Abubakar().also { instance = it }
            }
        }

        // Property for easy access to the color method
        val statusBar: Abubakar by lazy { getInstance() }
    }

    // Color method to change status bar color
    fun color(activity: Activity, colorHex: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor(colorHex)
        }
    }

    // Color method with direct Color argument
    fun color(activity: Activity, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }
}
