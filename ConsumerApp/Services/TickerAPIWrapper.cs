using Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public static class TickerAPIWrapper
    {
        private static string baseAPIUrl = "http://localhost:8080/api/v1/ticker";
        public static string BaseAPIUrl
        {
            get { return baseAPIUrl; }
            private set
            {
                baseAPIUrl = value;
            }
        }

        public static ObservableCollection<Ticker> GetTickers()
        {
            ObservableCollection<Ticker> tickers = new ObservableCollection<Ticker>();
            try
            {
                RequestService httpRequestService = new RequestService($"{baseAPIUrl}");
                string response = httpRequestService.GetRequest();

                tickers = JsonConvert.DeserializeObject<ObservableCollection<Ticker>>(response);
            }
            catch
            {
                throw new Exception($"Something went wrong during get reqest on {baseAPIUrl} api.");
            }
            return tickers;
        }

        public static ObservableCollection<Ticker> GetTickers(string PairName)
        {
            ObservableCollection<Ticker> tickers = new ObservableCollection<Ticker>();
            try
            {
                RequestService httpRequestService = new RequestService($"{baseAPIUrl}/{PairName}");
                string response = httpRequestService.GetRequest();

                tickers = JsonConvert.DeserializeObject<ObservableCollection<Ticker>>(response);
            }
            catch
            {
                throw new Exception($"Something went wrong during get reqest on {baseAPIUrl} api.");
            }
            return tickers;
        }

        public static ObservableCollection<Ticker> GetTickers(string Date, string PairName)
        {
            ObservableCollection<Ticker> tickers = new ObservableCollection<Ticker>();
            try
            {
                RequestService httpRequestService = new RequestService($"{baseAPIUrl}/{Date}/{PairName}");
                string response = httpRequestService.GetRequest();

                tickers = JsonConvert.DeserializeObject<ObservableCollection<Ticker>>(response);
            }
            catch
            {
                throw new Exception($"Something went wrong during get reqest on {baseAPIUrl} api.");
            }
            return tickers;
        }


        public static bool IsServiceOnline()
        {
            RequestService httpRequestService = new RequestService($"{baseAPIUrl}");
            return httpRequestService.IsServiceOnline();
        }

    }
}
