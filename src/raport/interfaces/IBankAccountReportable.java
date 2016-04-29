package raport.interfaces;

/**
 * Created by inf113149 on 2016-04-29.
 */
public interface IBankAccountReportable {
    void accept(IBankAccountReportVisitor visitor);
}
