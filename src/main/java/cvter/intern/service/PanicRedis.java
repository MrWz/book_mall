package cvter.intern.service;

import cvter.intern.model.Panic;

/**
 * Created by cvter on 2017/5/27.
 */
public interface PanicRedis {
    public Panic getPanic(String panicId);
    public String putPanic(Panic panicId);
}
