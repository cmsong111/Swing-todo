package com.gulio.todo_swing.configuration

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class ApplicationContextProvider : ApplicationContextAware {

    companion object {
        @JvmStatic
        private var applicationContext: ApplicationContext? = null

        @JvmStatic
        public fun getApplicationContext(): ApplicationContext? {
            return applicationContext
        }
    }

    override fun setApplicationContext(context: ApplicationContext) {
        applicationContext = context
    }
}
