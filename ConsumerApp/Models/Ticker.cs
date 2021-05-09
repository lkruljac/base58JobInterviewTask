using Common;
using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Ticker : BaseViewModel
    {
        private string _CreationTime;
        public string CreationTime
        {
            get { return _CreationTime; }
            set 
            { 
                _CreationTime = value;
                RaisePropertyChangedEvent("CreationTime");
            }
        }

        private JsonObject _Data;
        public JsonObject Data
        {
            get { return _Data; }
            set 
            {
                _Data = value;
                RaisePropertyChangedEvent("Data");
            }
        }

        private string _DataString;
        public string DataString
        {
            get { return JsonConvert.SerializeObject(Data);  }
            set
            {
                _DataString = value;
                RaisePropertyChangedEvent("DataString");
            }
        }

        private string _PairName;

        public string PairName
        {
            get { return _PairName; }
            set 
            { 
                _PairName = value;
                RaisePropertyChangedEvent("PairName");
            }
        }


    }
}
