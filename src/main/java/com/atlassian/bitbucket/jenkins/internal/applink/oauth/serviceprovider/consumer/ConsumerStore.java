package com.atlassian.bitbucket.jenkins.internal.applink.oauth.serviceprovider.consumer;

import com.atlassian.bitbucket.jenkins.internal.applink.oauth.serviceprovider.exception.StoreException;
import com.atlassian.bitbucket.jenkins.internal.applink.oauth.serviceprovider.temp.InMemoryConsumerStore;
import com.google.inject.ImplementedBy;

import java.util.Collection;

/**
 * Provides persistent storage for OAuth consumers. The implementation of this store should only concern itself
 * with the immediate task that it is being asked to perform.
 */
@ImplementedBy(InMemoryConsumerStore.class)
public interface ConsumerStore {

    /**
     * Add the consumer to the store.
     *
     * @param consumer the consumer
     */
    void add(Consumer consumer);

    /**
     * Retrieve a {@code Consumer} from the store whose {@code key} attribute is equal to the
     * {@code consumer} parameter.
     *
     * @param key the key
     * @return {@code Consumer} whose key is {@code token}
     */
    Consumer get(String key);

    /**
     * Deletes a consumer with the {@code key}.
     *
     * @param key the key
     */
    void delete(String key);

    /**
     * Retrieve all the {@code Consumers} from the store.
     *
     * @return all the {@code Consumers} from the store
     * @throws StoreException thrown if there is a problem retrieving one or more of the {@code Consumer}s
     */
    Collection<Consumer> getAll() throws StoreException;
}