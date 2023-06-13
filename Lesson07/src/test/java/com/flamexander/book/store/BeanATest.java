package com.flamexander.book.store;

import com.flamexander.book.store.utils.BeanA;
import com.flamexander.book.store.utils.BeanB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = {BeanA.class, BeanB.class})
public class BeanATest {
    @SpyBean
    private BeanB beanB;

    @Autowired
    private BeanA beanA;

    @Test
    public void aTest() {
        beanA.doSomething("Java");
        Mockito.verify(beanB).stringUp("Java");

        Mockito.when(beanB.stringUp("Java")).thenReturn("UP: Java");

    }
}
