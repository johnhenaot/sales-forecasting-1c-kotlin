package utils

import io.kotlintest.specs.StringSpec
import org.apache.spark.sql.SparkSession

class SparkSpec : StringSpec() {
    companion object {
        val spark: SparkSession =
            SparkSession
                .builder()
                .appName("Sales Forecasting 1C")
                .master("local[8]")
                .orCreate
                .apply {
                    conf()
                        .set("spark.sql.shuffle.partitions", "8")
                }
    }
}