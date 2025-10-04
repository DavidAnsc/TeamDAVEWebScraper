//
//  ContentView.swift
//  TeamDAVEWebScraper
//
//  Created by David An on 2025-09-20.
//

import SwiftUI
import UIKit

struct mainView: View {
	@State var defaultListModel = ultimateList()
	@State var isLoading = false
    var body: some View {
        VStack {
			NavigationStack {
				VStack {
					if defaultListModel.imageList.imageList.count > 0 {
						if defaultListModel.allImgs.count > 0 {
							Text(defaultListModel.allImgs.count.description)

						}
					} else {
						ProgressView("loading...")
					}
				}
			}
        }
        
        .padding()
    }
	
	
}

#Preview {
    mainView()
}
