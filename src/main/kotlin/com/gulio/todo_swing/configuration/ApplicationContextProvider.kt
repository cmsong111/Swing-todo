package com.gulio.todo_swing.configuration

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
object ApplicationContextProvider : ApplicationContextAware {

    private var applicationContext: ApplicationContext? = null

    override fun setApplicationContext(context: ApplicationContext) {
        applicationContext = context
    }

    fun getBean(beanName: String): Any {
        return applicationContext!!.getBean(beanName)
    }
}
