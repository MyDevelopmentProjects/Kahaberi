package ge.unknown.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ge.unknown.entities")
public class ElasticSearchConfiguration {

    @Value("${elasticsearch.enabled}")
    private boolean EsEnabled;

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public Client client() throws Exception {
        if(EsEnabled){
            Settings esSettings = Settings.settingsBuilder()
                    .put("cluster.name", EsClusterName)
                    .build();
            //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
            return TransportClient.builder()
                    .settings(esSettings)
                    .build()
                    .addTransportAddress(
                            new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
        } else {
            return TransportClient.builder().build();
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
    }
}
