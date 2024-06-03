package com.gulio.todo_swing.configuration

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * ApplicationContextProvider
 *
 * 해당 클래스는 스프링 컨테이너에 등록된 빈을 가져오기 위한 클래스입니다.
 */
@Component
object ApplicationContextProvider : ApplicationContextAware {

    /**
     * 스프링 컨테이너 객체
     */
    private var applicationContext: ApplicationContext? = null

    /**
     * 스프링 컨테이너에 등록된 빈을 등록하는 메소드
     *
     * @param context 스프링 컨테이너 객체
     */
    override fun setApplicationContext(context: ApplicationContext) {
        applicationContext = context
    }

    /**
     * 빈을 가져오는 메소드
     *
     * @param beanName 빈 이름
     * @return 빈 객체
     */
    fun getBean(beanName: String): Any {
        return applicationContext!!.getBean(beanName)
    }
}
