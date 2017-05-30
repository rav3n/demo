package mobisapps.passbook.network

import okhttp3.ResponseBody
import retrofit2.Converter

class PlistResponseBodyConverter<T> : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    @Override public T convert(ResponseBody value) throws IOException {
//        JsonReader jsonReader = gson.newJsonReader(value.charStream());
//        try {
//            return adapter.read(jsonReader);
//        } finally {
//            value.close();
//        }
//    }
}
