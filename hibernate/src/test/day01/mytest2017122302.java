package day01;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * Created by CY on 2017/12/23.
 */
public class mytest2017122302 {

    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure("OraclelHouse.cfg.xml").build();
        MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
        export.create(true, true);

    }
}
