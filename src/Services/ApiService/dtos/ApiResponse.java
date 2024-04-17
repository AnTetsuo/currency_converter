package Services.ApiService.dtos;

import com.google.gson.annotations.SerializedName;

public record ApiResponse(
        String result,
        @SerializedName("conversion_rates")
        ConversionRates conversionRates,
        @SerializedName("base_code")
        String baseCode,
        @SerializedName("error-type")
        String errorType
) { }
