package com.gulio.todo_swing.configuration

class BeanUtils {
     fun getBean(beanName: String): Any {
        return ApplicationContextProvider.getApplicationContext()!!.getBean(beanName)
    }
}
