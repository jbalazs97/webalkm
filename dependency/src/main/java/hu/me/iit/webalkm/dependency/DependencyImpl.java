package hu.me.iit.webalkm.dependency;

public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {}

    @Override
    public int helpNoParameterReturnValue() {
        return 45;
    }

    @Override
    public void helpWithParameterNoReturnValue(int a) {

    }
}
