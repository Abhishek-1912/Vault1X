package com.example.Vault1X.service;

// // import java.math.BigDecimal;
// // import java.math.RoundingMode;
// // import java.time.LocalDate;
// // import java.util.List;
// // // import static java.rmi.server.LogStream.log;
// // import java.util.Map;

// // import org.springframework.http.client.SimpleClientHttpRequestFactory;
// // import org.springframework.stereotype.Service;
// // import org.springframework.web.client.HttpClientErrorException;
// // import org.springframework.web.client.RestTemplate;

// // import java.util.ArrayList;
// // import java.util.HashMap;

// // import com.example.vaultX.Service.ExchangeRateService.ConversionRequest;
// // import
// com.example.vaultX.Service.ExchangeRateService.ExchangeRateApiResponse;
// // import com.example.vaultX.entity.Wallet;
// // import com.example.vaultX.enums.CurrencyType;
// // import org.slf4j.Logger;
// // import org.slf4j.LoggerFactory;
// // @Service
// // public class ExchangeRateService {
// // private static final Logger log =
// LoggerFactory.getLogger(ExchangeRateService.class);
// // private final RestTemplate restTemplate;
// // private final Map<String,CachedRate> rateCache= new
// HashMap<>();//concurrent is removed
// // private static final Integer Cache_TTL = 5*60*1000; //5min//modify from
// long to int
// // private static final String Api_Url =
// "https://api.exchangerate-api.com/v4/latest/";
// // public ExchangeRateService(){
// // this.restTemplate=new RestTemplate();
// // SimpleClientHttpRequestFactory factory = new
// SimpleClientHttpRequestFactory();
// // factory.setConnectTimeout(5000); //5sec
// // factory.setReadTimeout(10000);//10sec
// // this.restTemplate.setRequestFactory(factory);
// // }
// // public BigDecimal getExchangeRate(CurrencyType from, CurrencyType to){
// // if (from==to){
// // return BigDecimal.ONE;
// // }
// // String CacheKey = from.name()+'_'+to.name();
// // CachedRate cached = rateCache.get(CacheKey);
// // if (cached!=null && !cached.isExpired()){
// // log.debug ("Returning Cached Rate for {} to {}",from,to);
// // return cached.getRate();
// // }
// // //fetch from api
// // BigDecimal rate = fetchFromExchangeRateApi(from,to);
// // //cache
// // rateCache.put(CacheKey, new
// CachedRate(rate,System.currentTimeMillis()));//system.currentTimeMills()
// // return rate;
// // }
// // private BigDecimal fetchFromExchangeRateApi(CurrencyType from,
// CurrencyType to){
// // String url = Api_Url + from.name();
// // log.info("Fetching exchangerate from : {} ",url);
// // ExchangeRateApiResponse response = restTemplate.getForObject(url,
// ExchangeRateApiResponse.class);
// // try {
// // if (response == null || response.getRate()==null){
// // throw new RuntimeException("Invalid response from Exchangerate");
// // }
// // Double rate = response.getRate().get(to.name());
// // if (rate==null){
// // log.warn("Rate not found for {} to {},using FallBack",from,to);
// // return getfallbackrate(from,to);
// // }
// // return BigDecimal.valueOf(rate);

// // } catch (HttpClientErrorException e) {
// // log.error("Http error feteching rate",e.getStatusCode());
// // return getfallbackrate(from,to);//modified from getfallback to
// getfallbackrates
// // }
// // }
// // public ExchangeRateApiResponse getAllRates(CurrencyType base){
// // String url = Api_Url + base.name();
// // try {
// // ExchangeRateApiResponse response =
// restTemplate.getForObject(url,ExchangeRateApiResponse.class);
// // if (response!=null){
// // CacheallRates(base,response.getRate());
// // }
// // return response;

// // } catch (Exception e) {
// // log.error("Failed to fetch all rates for Base Currency {}",base,e);
// // return createFallBackresponse(base);
// // }
// // }
// // private void CacheallRates(CurrencyType base, Map<String,Double> rates){
// // for (Map.Entry<String,Double> entry:rates.entrySet()){
// // try{
// // CurrencyType to = CurrencyType.valueOf(entry.getKey());
// // String CacheKey = base.name()+'_'+to.name();
// // BigDecimal rate = BigDecimal.valueOf(entry.getValue());
// // rateCache.put(CacheKey,new CachedRate(rate,System.currentTimeMillis()));
// // }
// // catch(IllegalArgumentException e){
// // log.debug ("skipping caching for unsupported currency:
// {}",entry.getKey());
// // }
// // }
// // }
// // public BigDecimal convertCurrency(BigDecimal amount,CurrencyType base,
// CurrencyType to){
// // BigDecimal rate = getExchangeRate(base, to);
// // return
// amount.multiply(rate).setScale(8,RoundingMode.HALF_UP);//RoundingModeHalf_up
// // }
// // public Map<String,Object> getWalletinMultipleCurrencies(Wallet wallet,
// List<CurrencyType> targetCurrencies){
// // Map<String,Object> results = new HashMap<>();
// // //original currency
// // results.put("orignial",Map.of (
// //
// "Currency",wallet.getCurrency(),"Symbol",wallet.getCurrency().getsymbol(),"Balance",wallet.getbalance())
// // );
// // List<Map<String,Object>> conversions = new ArrayList<>();
// // for (CurrencyType target : targetCurrencies){
// // if (!target.equals( wallet.getCurrency())){
// // BigDecimal convertedamount =
// convertCurrency(wallet.getbalance(),wallet.getCurrency(),target);
// // BigDecimal rate = getExchangeRate(wallet.getCurrency(),target);
// // Map<String,Object> conversion = Map.of (
// //
// "currency",target,"symbol",target.getsymbol(),"balance",convertedamount,"rate",rate
// // );
// // conversions.add(conversion);
// // results.put("conversions",conversions);
// // }
// // }
// // return results;
// // // ExchangeRateApiResponse CachedRate
// // }
// // public BigDecimal getfallbackrate(CurrencyType from, CurrencyType to){
// // Map<String,BigDecimal> fallbackrates = new HashMap<>();
// // fallbackrates.put("USD_EUR",new BigDecimal("0.85"));
// // fallbackrates.put("USD_INR",new BigDecimal("90.50"));
// // fallbackrates.put("EUR_USD",new BigDecimal("1.18"));
// // fallbackrates.put("EUR_INR",new BigDecimal("105.08"));
// // fallbackrates.put("INR_USD",new BigDecimal("0.011"));
// // fallbackrates.put("INR_EUR",new BigDecimal("0.0095"));
// // fallbackrates.put("USD_BTC",new BigDecimal("0.000022"));
// // fallbackrates.put("USD_LTC",new BigDecimal("0.013"));
// // fallbackrates.put("BTC_USD",new BigDecimal("45000.00"));
// // fallbackrates.put("LTC_USD",new BigDecimal("150.00"));
// // fallbackrates.put("BTC_LTC",new BigDecimal("1122.70"));
// // fallbackrates.put("LTC_BTC",new BigDecimal("0.00089"));
// // String key = from.name()+"_" + to.name();
// // if (fallbackrates.containsKey(key)){
// // log.warn("Using fallbackrate for {} to
// {}",from,to,fallbackrates.get(key));
// // return fallbackrates.get(key);
// // }
// // String reversekey = to.name()+"_"+from.name();
// // if (fallbackrates.containsKey(reversekey)){
// // BigDecimal reverserate =fallbackrates.get(reversekey);
// // BigDecimal rate =
// BigDecimal.ONE.divide(reverserate,8,RoundingMode.HALF_UP);
// // log.warn ("Using inverse fallbackrate for {} to {}",to ,from,rate);
// // return rate;
// // }
// // log.error("No fallBack rate found for {} to {},using 1.0",from,to);
// // return BigDecimal.ONE;
// // }
// // public ExchangeRateApiResponse Createfallbackresponse(CurrencyType base){
// // ExchangeRateApiResponse response = new ExchangeRateApiResponse();
// // response.setBase("base Currency",base.name());
// // response.setDate(LocalDate.now().toString());
// // Map<String,Double> rates = new HashMap<>();
// // rates.put("USD",base==CurrencyType.USD? 1.0:getfallbackrate(base,
// CurrencyType.USD).doubleValue());
// // rates.put("EUR",base==CurrencyType.EUR? 1.0:getfallbackrate(base,
// CurrencyType.EUR).doubleValue());
// // rates.put("INR",base==CurrencyType.INR? 1.0:getfallbackrate(base,
// CurrencyType.INR).doubleValue());
// // rates.put("BTC",base==CurrencyType.BTC? 1.0:getfallbackrate(base,
// CurrencyType.BTC).doubleValue());
// // rates.put("LTC",base==CurrencyType.LTC? 1.0:getfallbackrate(base,
// CurrencyType.LTC).doubleValue());
// // response.setRates(rates);
// // return response;
// // }
// // @Data
// // public static class ExchangeRateApiResponse {
// // private String base;
// // private String date;
// // private Map<String, Double> rates;
// // }

// // @Data
// // @AllArgsConstructor
// // public static class ConversionRequest {
// // private BigDecimal amount;
// // private CurrencyType fromCurrency;
// // private CurrencyType toCurrency;
// // }

// // @Data
// // @AllArgsConstructor
// // public static class ConversionResult {
// // private ConversionRequest request;
// // private BigDecimal convertedAmount;
// // }
// // public void clearcache(){
// // rateCache.clear();
// // log.info("Exchange rate cache cleared");
// // }
// // public Map<String,Object> getCacheRate(){
// // return Map.of(
// // "size",rateCache.size(),
// // "keys",rateCache.keySet()
// // );
// // }
// // private static class CachedRate{
// // private final BigDecimal rate;
// // private final long timeStamp;
// // public CachedRate(BigDecimal rate,Long timeStamp){
// // this.rate = rate;
// // this.timeStamp = timeStamp;
// // }
// // public boolean isExpired(){
// // return System.currentTimeMillis()-timeStamp>Cache_TTL;
// // }
// // public BigDecimal getRate(){
// // return rate;
// // }
// // }
// package com.example.vaultX.Service;

// import java.math.BigDecimal;
// import java.math.RoundingMode;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Map;
// import java.util.ArrayList;
// import java.util.HashMap;

// import org.springframework.http.client.SimpleClientHttpRequestFactory;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.HttpClientErrorException;
// import org.springframework.web.client.RestTemplate;

// import com.example.vaultX.entity.Wallet;
// import com.example.vaultX.enums.CurrencyType;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Service
// public class ExchangeRateService {
// private static final Logger log =
// LoggerFactory.getLogger(ExchangeRateService.class);
// private final RestTemplate restTemplate;
// private final Map<String, CachedRate> rateCache = new HashMap<>();
// private static final long CACHE_TTL = 5 * 60 * 1000; // 5 minutes in
// milliseconds
// private static final String API_URL =
// "https://api.exchangerate-api.com/v4/latest/";

// public ExchangeRateService() {
// this.restTemplate = new RestTemplate();
// SimpleClientHttpRequestFactory factory = new
// SimpleClientHttpRequestFactory();
// factory.setConnectTimeout(5000); // 5 seconds
// factory.setReadTimeout(10000); // 10 seconds
// this.restTemplate.setRequestFactory(factory);
// }

// public BigDecimal getExchangeRate(CurrencyType from, CurrencyType to) {
// if (from == to) {
// return BigDecimal.ONE;
// }
// String cacheKey = from.name() + "_" + to.name();
// CachedRate cached = rateCache.get(cacheKey);
// if (cached != null && !cached.isExpired()) {
// log.debug("Returning cached rate for {} to {}", from, to);
// return cached.getRate();
// }
// // Fetch from API
// BigDecimal rate = fetchFromExchangeRateApi(from, to);
// // Cache the rate
// rateCache.put(cacheKey, new CachedRate(rate, System.currentTimeMillis()));
// return rate;
// }

// private BigDecimal fetchFromExchangeRateApi(CurrencyType from, CurrencyType
// to) {
// String url = API_URL + from.name();
// log.info("Fetching exchange rate from: {}", url);
// try {
// ExchangeRateApiResponse response = restTemplate.getForObject(url,
// ExchangeRateApiResponse.class);
// if (response == null || response.getRates() == null) {
// throw new RuntimeException("Invalid response from Exchange Rate API");
// }
// Double rate = response.getRates().get(to.name());
// if (rate == null) {
// log.warn("Rate not found for {} to {}, using fallback", from, to);
// return getFallbackRate(from, to);
// }
// return BigDecimal.valueOf(rate);
// } catch (HttpClientErrorException e) {
// log.error("HTTP error fetching rate: {}", e.getStatusCode());
// return getFallbackRate(from, to);
// } catch (Exception e) {
// log.error("Error fetching rate from API", e);
// return getFallbackRate(from, to);
// }
// }

// public ExchangeRateApiResponse getAllRates(CurrencyType base) {
// String url = API_URL + base.name();
// try {
// ExchangeRateApiResponse response = restTemplate.getForObject(url,
// ExchangeRateApiResponse.class);
// if (response != null) {
// cacheAllRates(base, response.getRates());
// }
// return response;
// } catch (Exception e) {
// log.error("Failed to fetch all rates for base currency {}", base, e);
// return createFallbackResponse(base);
// }
// }

// private void cacheAllRates(CurrencyType base, Map<String, Double> rates) {
// if (rates == null) return;

// for (Map.Entry<String, Double> entry : rates.entrySet()) {
// try {
// CurrencyType to = CurrencyType.valueOf(entry.getKey());
// String cacheKey = base.name() + "_" + to.name();
// BigDecimal rate = BigDecimal.valueOf(entry.getValue());
// rateCache.put(cacheKey, new CachedRate(rate, System.currentTimeMillis()));
// } catch (IllegalArgumentException e) {
// log.debug("Skipping caching for unsupported currency: {}", entry.getKey());
// }
// }
// }

// public BigDecimal convertCurrency(BigDecimal amount, CurrencyType base,
// CurrencyType to) {
// BigDecimal rate = getExchangeRate(base, to);
// return amount.multiply(rate).setScale(8, RoundingMode.HALF_UP);
// }

// public Map<String, Object> getWalletInMultipleCurrencies(Wallet wallet,
// List<CurrencyType> targetCurrencies) {
// Map<String, Object> results = new HashMap<>();
// // Original currency
// results.put("original", Map.of(
// "currency", wallet.getCurrency(),
// "symbol", wallet.getCurrency().getsymbol(),
// "balance", wallet.getbalance()
// ));

// List<Map<String, Object>> conversions = new ArrayList<>();
// for (CurrencyType target : targetCurrencies) {
// if (!target.equals(wallet.getCurrency())) {
// BigDecimal convertedAmount = convertCurrency(wallet.getbalance(),
// wallet.getCurrency(), target);
// BigDecimal rate = getExchangeRate(wallet.getCurrency(), target);
// Map<String, Object> conversion = Map.of(
// "currency", target,
// "symbol", target.getsymbol(),
// "balance", convertedAmount,
// "rate", rate
// );
// conversions.add(conversion);
// }
// }
// results.put("conversions", conversions);
// return results;
// }

// public BigDecimal getFallbackRate(CurrencyType from, CurrencyType to) {
// Map<String, BigDecimal> fallbackRates = new HashMap<>();
// fallbackRates.put("USD_EUR", new BigDecimal("0.85"));
// fallbackRates.put("USD_INR", new BigDecimal("90.50"));
// fallbackRates.put("EUR_USD", new BigDecimal("1.18"));
// fallbackRates.put("EUR_INR", new BigDecimal("105.08"));
// fallbackRates.put("INR_USD", new BigDecimal("0.011"));
// fallbackRates.put("INR_EUR", new BigDecimal("0.0095"));
// fallbackRates.put("USD_BTC", new BigDecimal("0.000022"));
// fallbackRates.put("USD_LTC", new BigDecimal("0.013"));
// fallbackRates.put("BTC_USD", new BigDecimal("45000.00"));
// fallbackRates.put("LTC_USD", new BigDecimal("150.00"));
// fallbackRates.put("BTC_LTC", new BigDecimal("1122.70"));
// fallbackRates.put("LTC_BTC", new BigDecimal("0.00089"));

// String key = from.name() + "_" + to.name();
// if (fallbackRates.containsKey(key)) {
// log.warn("Using fallback rate for {} to {}: {}", from, to,
// fallbackRates.get(key));
// return fallbackRates.get(key);
// }

// String reverseKey = to.name() + "_" + from.name();
// if (fallbackRates.containsKey(reverseKey)) {
// BigDecimal reverseRate = fallbackRates.get(reverseKey);
// BigDecimal rate = BigDecimal.ONE.divide(reverseRate, 8,
// RoundingMode.HALF_UP);
// log.warn("Using inverse fallback rate for {} to {}: {}", from, to, rate);
// return rate;
// }

// log.error("No fallback rate found for {} to {}, using 1.0", from, to);
// return BigDecimal.ONE;
// }

// private ExchangeRateApiResponse createFallbackResponse(CurrencyType base) {
// ExchangeRateApiResponse response = new ExchangeRateApiResponse();
// response.setBase(base.name());
// response.setDate(LocalDate.now().toString());

// Map<String, Double> rates = new HashMap<>();
// rates.put("USD", base == CurrencyType.USD ? 1.0 : getFallbackRate(base,
// CurrencyType.USD).doubleValue());
// rates.put("EUR", base == CurrencyType.EUR ? 1.0 : getFallbackRate(base,
// CurrencyType.EUR).doubleValue());
// rates.put("INR", base == CurrencyType.INR ? 1.0 : getFallbackRate(base,
// CurrencyType.INR).doubleValue());
// rates.put("BTC", base == CurrencyType.BTC ? 1.0 : getFallbackRate(base,
// CurrencyType.BTC).doubleValue());
// rates.put("LTC", base == CurrencyType.LTC ? 1.0 : getFallbackRate(base,
// CurrencyType.LTC).doubleValue());

// response.setRates(rates);
// return response;
// }

// public void clearCache() {
// rateCache.clear();
// log.info("Exchange rate cache cleared");
// }

// public Map<String, Object> getCacheInfo() {
// return Map.of(
// "size", rateCache.size(),
// "keys", rateCache.keySet()
// );
// }

// // Inner classes without Lombok
// public static class ExchangeRateApiResponse {
// private String base;
// private String date;
// private Map<String, Double> rates;

// public String getBase() {
// return base;
// }

// public void setBase(String base) {
// this.base = base;
// }

// public String getDate() {
// return date;
// }

// public void setDate(String date) {
// this.date = date;
// }

// public Map<String, Double> getRates() {
// return rates;
// }

// public void setRates(Map<String, Double> rates) {
// this.rates = rates;
// }
// }

// public static class ConversionRequest {
// private BigDecimal amount;
// private CurrencyType fromCurrency;
// private CurrencyType toCurrency;

// public ConversionRequest() {}

// public ConversionRequest(BigDecimal amount, CurrencyType fromCurrency,
// CurrencyType toCurrency) {
// this.amount = amount;
// this.fromCurrency = fromCurrency;
// this.toCurrency = toCurrency;
// }

// public BigDecimal getAmount() {
// return amount;
// }

// public void setAmount(BigDecimal amount) {
// this.amount = amount;
// }

// public CurrencyType getFromCurrency() {
// return fromCurrency;
// }

// public void setFromCurrency(CurrencyType fromCurrency) {
// this.fromCurrency = fromCurrency;
// }

// public CurrencyType getToCurrency() {
// return toCurrency;
// }

// public void setToCurrency(CurrencyType toCurrency) {
// this.toCurrency = toCurrency;
// }
// }

// public static class ConversionResult {
// private ConversionRequest request;
// private BigDecimal convertedAmount;

// public ConversionResult() {}

// public ConversionResult(ConversionRequest request, BigDecimal
// convertedAmount) {
// this.request = request;
// this.convertedAmount = convertedAmount;
// }

// public ConversionRequest getRequest() {
// return request;
// }

// public void setRequest(ConversionRequest request) {
// this.request = request;
// }

// public BigDecimal getConvertedAmount() {
// return convertedAmount;
// }

// public void setConvertedAmount(BigDecimal convertedAmount) {
// this.convertedAmount = convertedAmount;
// }
// }

// private static class CachedRate {
// private final BigDecimal rate;
// private final long timestamp;

// public CachedRate(BigDecimal rate, long timestamp) {
// this.rate = rate;
// this.timestamp = timestamp;
// }

// public boolean isExpired() {
// return System.currentTimeMillis() - timestamp > CACHE_TTL;
// }

// public BigDecimal getRate() {
// return rate;
// }
// }
// }