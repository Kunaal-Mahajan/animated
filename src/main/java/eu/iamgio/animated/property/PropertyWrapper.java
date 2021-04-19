package eu.iamgio.animated.property;

import eu.iamgio.animated.AnimationSettings;
import eu.iamgio.animated.CustomizableAnimation;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;

/**
 * Abstract class that allows wrapping object and primitive JavaFX properties without the explicit <pre>asObject()</pre> call ands allows animation customization.
 * @param <T> property type
 * @author Giorgio Garofalo
 */
public abstract class PropertyWrapper<T> implements CustomizableAnimation<PropertyWrapper<T>> {

    /**
     * @return the wrapped JavaFX property
     */
    public abstract Property<T> getProperty();

    /**
     * Changes the value of the wrapped property
     * @param value new value to set
     */
    public abstract void set(T value);

    /**
     * Registers a listener
     * @param listener listener to register
     */
    public abstract void addListener(ChangeListener<? super T> listener);

    private AnimationSettings settings = new AnimationSettings();

    /**
     * {@inheritDoc}
     */
    public AnimationSettings getSettings() {
        return settings;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <A extends PropertyWrapper<T>> A withSettings(AnimationSettings settings) {
        this.settings = settings;
        return (A) this;
    }
}
