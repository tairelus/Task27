package bjs.task27;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        //Class object for Thread
        Class classObj = Thread.class;

        //Get class names
        System.out.println("Class names");
        System.out.println("\tgetName() = " + classObj.getName());
        System.out.println("\tgetSimpleName() = " + classObj.getSimpleName());
        System.out.println("\tgetCanonicalName() = " + classObj.getCanonicalName());
        System.out.println("\tgetTypeName() = " + classObj.getTypeName());

        //Modifiers
        System.out.println("\nClass modifiers");
        int classModifiers = classObj.getModifiers();

        if (Modifier.isPublic(classModifiers)) {
            System.out.println("\tpublic");
        }

        if (Modifier.isAbstract(classModifiers)) {
            System.out.println("\tabstract");
        }

        if (Modifier.isFinal(classModifiers)) {
            System.out.println("\tfinal");
        }

        //Superclass
        System.out.println("\nSuperclass");
        System.out.println("\t" + classObj.getSuperclass().getName());

        //Interfaces, implemented by the class
        System.out.println("\nInterfaces, implemented by the class");
        Class[] interfaces = classObj.getInterfaces();

        for(Class cInterface : interfaces) {
            System.out.println("\t" + cInterface.getName());
        }

        //All fields, including private and protected
        System.out.println("\nAll fields, including private and protected");
        Field[] fields = classObj.getDeclaredFields();

        for (Field field : fields) {
            int fieldModifiers = field.getModifiers();
            String fieldDescription = "\t";

            if (Modifier.isFinal(fieldModifiers)) {
                fieldDescription += "final ";
            }

            if (Modifier.isPublic(fieldModifiers)) {
                fieldDescription += "public ";
            }

            if (Modifier.isProtected(fieldModifiers)) {
                fieldDescription += "protected ";
            }

            if (Modifier.isPrivate(fieldModifiers)) {
                fieldDescription += "private ";
            }

            fieldDescription += field.getType().getSimpleName() + " ";
            fieldDescription += field.getName() + ";";
            System.out.println(fieldDescription);
        }

        //All methods, including private and protected
        System.out.println("\nAll methods, including private and protected");
        Method[] methods = classObj.getDeclaredMethods();

        for (Method method : methods) {
            int methodModifiers = method.getModifiers();
            String methodDescription = "\t";

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                methodDescription += "@" + annotation.annotationType().getSimpleName() + "\n\t";
            }

            if (Modifier.isAbstract(methodModifiers)) {
                methodDescription += "abstract ";
            }

            if (Modifier.isPublic(methodModifiers)) {
                methodDescription += "public ";
            }

            if (Modifier.isProtected(methodModifiers)) {
                methodDescription += "protected ";
            }

            if (Modifier.isPrivate(methodModifiers)) {
                methodDescription += "private ";
            }

            methodDescription += method.getReturnType().getSimpleName() + " ";
            methodDescription += method.getName() + "(";

            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                methodDescription += paramTypes[i].getSimpleName();
                if (i > 0 && i < paramTypes.length - 1) {
                    methodDescription += ", ";
                }
            }

            methodDescription += ");";
            System.out.println(methodDescription);
        }
    }
}

/*
Class names
	getName() = java.lang.Thread
	getSimpleName() = Thread
	getCanonicalName() = java.lang.Thread
	getTypeName() = java.lang.Thread

Class modifiers
	public

Superclass
	java.lang.Object

Interfaces, implemented by the class
	java.lang.Runnable

All fields, including private and protected
	private char[] name;
	private int priority;
	private Thread threadQ;
	private long eetop;
	private boolean single_step;
	private boolean daemon;
	private boolean stillborn;
	private Runnable target;
	private ThreadGroup group;
	private ClassLoader contextClassLoader;
	private AccessControlContext inheritedAccessControlContext;
	private int threadInitNumber;
	ThreadLocalMap threadLocals;
	ThreadLocalMap inheritableThreadLocals;
	private long stackSize;
	private long nativeParkEventPointer;
	private long tid;
	private long threadSeqNumber;
	private int threadStatus;
	Object parkBlocker;
	private Interruptible blocker;
	final private Object blockerLock;
	final public int MIN_PRIORITY;
	final public int NORM_PRIORITY;
	final public int MAX_PRIORITY;
	final private StackTraceElement[] EMPTY_STACK_TRACE;
	final private RuntimePermission SUBCLASS_IMPLEMENTATION_PERMISSION;
	private UncaughtExceptionHandler uncaughtExceptionHandler;
	private UncaughtExceptionHandler defaultUncaughtExceptionHandler;
	long threadLocalRandomSeed;
	int threadLocalRandomProbe;
	int threadLocalRandomSecondarySeed;

All methods, including private and protected
	public void run();
	private void exit();
	private void dispatchUncaughtException(Throwable);
	public String toString();
	protected Object clone();
	public boolean isInterrupted();
	private boolean isInterrupted(boolean);
	public Thread currentThread();
	public String getName();
	private void registerNatives();
	public void join(long);
	public void join(longint);
	public void join();
	public ThreadGroup getThreadGroup();
	private void init(ThreadGroupRunnable, String, long, AccessControlContext);
	private void init(ThreadGroupRunnable, String, long);
	public StackTraceElement[] getStackTrace();
	public boolean holdsLock(Object);
	public void checkAccess();
	public void dumpStack();
	public void setDaemon(boolean);
	public void setPriority(int);
	public void start();
	public int activeCount();
	private boolean auditSubclass(Class);
	void blockedOn(Interruptible);
	@Deprecated
	public int countStackFrames();
	@Deprecated
	public void destroy();
	private StackTraceElement[][] dumpThreads(Thread[]);
	public int enumerate(Thread[]);
	public Map getAllStackTraces();
	@CallerSensitive
	public ClassLoader getContextClassLoader();
	public UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();
	public long getId();
	public int getPriority();
	public State getState();
	private Thread[] getThreads();
	public UncaughtExceptionHandler getUncaughtExceptionHandler();
	public void interrupt();
	private void interrupt0();
	public boolean interrupted();
	public boolean isAlive();
	private boolean isCCLOverridden(Class);
	public boolean isDaemon();
	private long nextThreadID();
	private int nextThreadNum();
	void processQueue(ReferenceQueueConcurrentMap);
	@Deprecated
	public void resume();
	private void resume0();
	public void setContextClassLoader(ClassLoader);
	public void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler);
	public void setName(String);
	private void setNativeName(String);
	private void setPriority0(int);
	public void setUncaughtExceptionHandler(UncaughtExceptionHandler);
	public void sleep(long);
	public void sleep(longint);
	private void start0();
	@Deprecated
	public void stop(Throwable);
	@Deprecated
	public void stop();
	private void stop0(Object);
	@Deprecated
	public void suspend();
	private void suspend0();
	public void yield();
 */