/*
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://jersey.dev.java.net/CDDL+GPL.html
 * or jersey/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at jersey/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.sun.jersey.core.spi.component;

import com.sun.jersey.core.reflection.AnnotatedMethod;
import com.sun.jersey.core.reflection.MethodList;
import com.sun.jersey.core.reflection.ReflectionHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A destructor of a component.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public class ComponentDestructor {
    private final Method preDestroy;

    /**
     * Create a component destructor.
     *
     * @param c the class of instances to destruct.
     */
    public ComponentDestructor(Class c) {
        this.preDestroy = getPreDestroyMethod(c);
    }

    private static Method getPreDestroyMethod(Class c) {
    	/*
        Class preDestroyClass = ReflectionHelper.classForName("javax.annotation.PreDestroy");
        if (preDestroyClass != null) {
            MethodList methodList = new MethodList(c);
            for (AnnotatedMethod m : methodList.
                    hasAnnotation(preDestroyClass).
                    hasNumParams(0).
                    hasReturnType(void.class)) {
                return m.getMethod();
            }
        }
        */
        return null;
    }

    public void destroy(Object o) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        if (preDestroy != null)
            preDestroy.invoke(o);
    }
}