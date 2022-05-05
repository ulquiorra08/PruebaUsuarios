package com.prueba.demo.modelsTest;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterEnum;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestModels {

        private static final int EXPECTED_CLASS_COUNT = 2;

        private static final String POJO_PACKAGE = "com.prueba.demo.models";

        protected Validator validator;

        private List<PojoClass> pojoClasses;

        @Test
        public void testPojos() {
            Validator validator = ValidatorBuilder.create().with(new Tester[]{new SetterTester()}).with(new Tester[]{new GetterTester()}).build();
            List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterChain(new FilterPackageInfo(), new FilterEnum()));
            Affirm.affirmEquals("Classes added / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());
            validator.validate(POJO_PACKAGE, new FilterPackageInfo());
            getTestin(pojoClasses);
        }

        public void getTestin(List<PojoClass> pojoClasses){
            Iterator var1 = pojoClasses.iterator();

            while (var1.hasNext()) {
                PojoClass pojoClass = (PojoClass) var1.next();
                ValidationHelper.getBasicInstance(pojoClass).toString();
                ValidationHelper.getMostCompleteInstance(pojoClass).toString();
            }
        }

}

